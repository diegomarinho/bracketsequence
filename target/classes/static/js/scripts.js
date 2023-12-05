document.getElementById('validateButton').addEventListener('click', validateBracketSequence);

function validateBracketSequence() {
    var bracketSequence = document.getElementById('bracketSequence').value;

    fetch('https://bracketsequence.vercel.app/bracketsequence/api/bracket/validate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        },
        body: JSON.stringify({ sequence: bracketSequence }),
    })
    .then(response => response.json())
    .then(data => {
        // Verificar se 'data' é indefinido
        if (data === undefined) {
            console.error('Resposta indefinida da API');
            return;
        }

        // Manipular a resposta
        console.log(data);

        var resultElement = document.getElementById('result');

        // Verificar se 'data.message' é indefinido
        if (data.message === undefined) {
            resultElement.innerText = 'Resposta da API inválida';
            resultElement.style.color = 'red';  // Estilizar para erro
            return;
        }

        resultElement.innerText = data.message;

        if (data.status === 'success') {
            resultElement.style.color = 'green';  // Estilizar para sucesso
        } else if (data.status === 'error') {
            resultElement.style.color = 'red';    // Estilizar para erro
        } else {
          resultElement.style.color = 'black';    // Estilizar para indefinido
          resultElement.innerText = data.message;
        }
    })
    .catch(error => {
        console.error('Erro:', error);
    });
}
