const moviesSection = document.querySelector("#movies-section");

// 3)
function showMovies(movies) {
    movies.forEach(movie => {
        const element = `<div class="movie">
            <p class="title">${movie.title} (${movie.year})</p>
        </div>`;
        moviesSection.insertAdjacentHTML("beforeend", element)
    })
}


// 2)
let loadMovies = () => {
    fetch("/movies")
        .then(r => r.json())
        .then(showMovies)
};

// 1)
document.addEventListener("DOMContentLoaded", loadMovies)