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
  
    alert(`Contratante salvo:\n${nome}, ${cpf}, ${profissao}, ${entidade}`);
    closeModal('contratanteModal');
  }
  
  // Carro
  function salvarCarro() {
    const modelo = document.getElementById('modeloCarro').value;
    const ano = document.getElementById('anoCarro').value;
    const placa = document.getElementById('placaCarro').value;
  
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
  
    const li = document.createElement('li');
    li.textContent = `Aluguel de ID ${registro}: Carro ${autoId}, Contratante ${contratanteId} de ${dataInicio} até ${dataFim}`;
    document.getElementById('aluguel-list').appendChild(li);
  
    closeModal('aluguelModal');
  }
  