const toggleLink = document.getElementById('toggle-link');
const formTitle = document.getElementById('form-title');
const extraField = document.getElementById('extra-field');
const form = document.getElementById('form');

let isLogin = true;

toggleLink.addEventListener('click', (e) => {
  e.preventDefault();
  isLogin = !isLogin;

  if (isLogin) {
    formTitle.textContent = 'Login';
    toggleLink.textContent = 'Cadastre-se';
    extraField.style.display = 'none';
  } else {
    formTitle.textContent = 'Cadastro';
    toggleLink.textContent = 'Já tem conta? Faça login';
    extraField.style.display = 'block';
  }
});

form.addEventListener('submit', (e) => {
  e.preventDefault();
  alert(isLogin ? 'Login feito (?)' : 'Cadastro enviado (?)');
});
