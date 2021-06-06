function trocarClasse() {
  var navbar = document.querySelector("nav");
  if (navbar.className != "responsive") {
  	navbar.classList.remove("navbar");
    navbar.classList.add("responsive");
  }
  else {
    navbar.classList.remove("responsive");
    navbar.classList.add("navbar");
  }
}