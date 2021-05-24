const moviesSection = document.querySelector("#movies-section");

function deleteMovie(id) {
    fetch(`/movies/${id}`, {method: 'DELETE'})
        .then(reloadMovies)
}

function likeMovie(id) {
    fetch("/movies/${id}/like", { method: 'PUT'})
        .then(reloadMovies)
}

function sendForm(event, form) {
    fetch(form.action, {method: 'post', body: new FormData(form)})
        .then(reloadMovies);
    event.preventDefault();
}

let reloadMovies = () => {
    fetch("/movies")
        .then(r => r.text())
        .then(moviesFragment => {
            moviesSection.innerHTML = moviesFragment
        })
};

document.addEventListener("DOMContentLoaded", reloadMovies)