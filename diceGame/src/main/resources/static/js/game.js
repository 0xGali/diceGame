function lancer_les_des() {
    fetch('/rollDice', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => response.json())
        .then(data => {
            // Mise à jour des dés affichés
            document.getElementById('de1').innerHTML = data.dice1;
            document.getElementById('de2').innerHTML = data.dice2;

            const lignes = document.querySelectorAll('table tr:not(:first-child)');
            let ligneTrouvee = false; // Déclaration de la variable

            lignes.forEach(ligne => {
                if (ligneTrouvee) return; // On sort de la boucle si on a déjà trouvé

                const cells = ligne.querySelectorAll('td');
                if (cells.length === 2) {
                    const val1 = cells[0].textContent.trim();
                    const val2 = cells[1].textContent.trim();
                    // Si les deux cellules sont vides ou valent 0
                    if ((val1 === "" || val1 === "0") && (val2 === "" || val2 === "0")) {
                        cells[0].textContent = data.dice1;
                        cells[1].textContent = data.dice2;
                        ligneTrouvee = true;
                    }
                }
            });

            // Calcul du score total
            let score_total = calculer_score();
            document.getElementById('score_total').innerHTML = "Score total : " + score_total;
            verif_fin_de_partie();
        })
        .catch(error => {
            console.error('Erreur:', error);
        });
}


function calculer_score() {
    let score = 0;
    // On récupère toutes les lignes du tableau (sauf la première, qui est l'en-tête)
    const lignes = document.querySelectorAll('table tr:not(:first-child)');

    lignes.forEach(ligne => {
        // On récupère les deux cellules de la ligne
        const cells = ligne.querySelectorAll('td');
        if (cells.length === 2) {
            const val1 = parseInt(cells[0].textContent);
            const val2 = parseInt(cells[1].textContent);
            if (val1 + val2 === 7) {
                score += 10;
            }
        }
    });

    return score;
}

//vérifie si la partie est terminée
//si oui, bloque le lancer de dés et affiche le formulaire pour enregistrer son score
function verif_fin_de_partie(){
    const lignes = document.querySelectorAll('table tr:not(:first-child)');
    let partieTerminee = true; // Déclaration de la variable

    lignes.forEach(ligne => {
        const cells = ligne.querySelectorAll('td');
        if (cells.length === 2) {
            const val1 = cells[0].textContent.trim();
            const val2 = cells[1].textContent.trim();
            // Si les deux cellules sont vides ou valent 0, la partie n'est pas terminée
            if ((val1 === "" || val1 === "0") && (val2 === "" || val2 === "0")) {
                partieTerminee = false;
            }
        }
    });
    if(partieTerminee) {
        document.getElementById('playbutton').disabled = true;
        document.getElementById('partieterminee').hidden = false;
    }
}

function enregistrer_partie(){
    let name = document.getElementById('name').value;
    let score = calculer_score();
    let submitButton = document.getElementById('submitbutton');
    submitButton.disabled = true;
    fetch('/enregistrerPartie', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name: name, score: score })
    })
        .then(response => {
            if (response.ok) {
                window.location.href = '/highscore'; // Redirection après succès
            } else {
                console.error('Erreur lors de l\'enregistrement');
                submitButton.disabled = false;
            }
        })
        .catch(error => {
            console.error('Erreur:', error);
            submitButton.disabled = false;
        });
}