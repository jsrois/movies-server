const moviesSection = document.querySelector("#movies-section");

// 3)

function deleteMovie(id) {
    fetch(`/movies/${id}`, {method: 'DELETE'})
        .then(reloadMovies)
}


// 2)
let reloadMovies = () => {
    fetch("/movies")
        .then(r => r.text())
        .then(moviesFragment => {
            moviesSection.innerHTML = moviesFragment
        })
};

// 1)
document.addEventListener("DOMContentLoaded", reloadMovies)