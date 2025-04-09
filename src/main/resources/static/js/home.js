// Modal functions
function openModal(id) {
    document.getElementById(id).style.display = 'flex';
  }
  function closeModal(id) {
    document.getElementById(id).style.display = 'none';
  }
  
  // Contratante
  function salvarContratante() {
    const nome = document.getElementById('nomeContratante').value;
    const cpf = document.getElementById('cpfContratante').value;
    const profissao = document.getElementById('profissaoContratante').value;
    const entidade = document.getElementById('entidadeContratante').value;

    const contratante = {
      id: 0,
      nome: nome,
      cpf: cpf,
      profissao: profissao,
      entidade: entidade
    }
    fetch('/contratante/create', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ contratante })
    })
  
    alert(`Contratante salvo:\n${nome}, ${cpf}, ${profissao}, ${entidade}`);
    closeModal('contratanteModal');
  }
  
  // Carro
  function salvarCarro() {
    const modelo = document.getElementById('modeloCarro').value;
    const ano = document.getElementById('anoCarro').value;
    const placa = document.getElementById('placaCarro').value;

    const automovel= {
      id: 0,
      modelo: modelo,
      ano: ano,
      placa: placa
    }

    fetch('/automovel/create', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ automovel})
    })
  
    alert(`Carro salvo:\n${modelo}, ${ano}, ${placa}`);
    closeModal('carroModal');
  }
  
  // Aluguel
  function salvarAluguel() {
    const dataInicio = document.getElementById('dataInicio').value;
    const dataFim = document.getElementById('dataFim').value;
    const registro = document.getElementById('registro').value;
    const autoId = document.getElementById('autoId').value;
    const contratanteId = document.getElementById('contratanteId').value;

    const aluguel = {
      id:0,
      dataInicio: dataInicio,
      dataFim: dataFim,
      registro: registro,
      automovel: {
        id: autoId
      },
      contratante: {
        id: contratanteId
      }}
      
      fetch('/aluguel/create', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ aluguel })
      })
  
    const li = document.createElement('li');
    li.textContent = `Aluguel de ID ${registro}: Carro ${autoId}, Contratante ${contratanteId} de ${dataInicio} até ${dataFim}`;
    document.getElementById('aluguel-list').appendChild(li);
  
    closeModal('aluguelModal');
  }
  