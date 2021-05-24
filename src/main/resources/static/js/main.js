const moviesSection = document.querySelector("#movies-section");

function deleteMovie(id) {
    fetch(`/movies/${id}`, {method: 'DELETE'})
        .then(reloadMovies)
}

function markAsFavourite(id, enable ) {
    fetch(`/movies/${id}/favourite/${enable}`, { method: 'PUT'})
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

let reloadFavouriteMovies = () => {
    fetch("/movies?favourites=true")
        .then(r => r.text())
        .then(moviesFragment => {
            moviesSection.innerHTML = moviesFragment
        })
};


document.addEventListener("DOMContentLoaded", reloadMovies)

const loadAllMoviesButton = document.querySelector("#load-all-movies")
const loadFavouriteMoviesButton = document.querySelector("#load-favourite-movies")

loadAllMoviesButton.addEventListener("click", reloadMovies)
loadFavouriteMoviesButton.addEventListener("click", reloadFavouriteMovies)