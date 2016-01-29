function fun() {
    var login = document.getElementById('login');
    var pass = document.getElementById('password');
    var el = document.getElementById('elh');
    if (login.value === pass.value) {
        el.innerHTML = login.value + '*' + pass.value;
    }
}