const moviesSection = document.querySelector("#movies-section");

// 3)
function showMovies(movies) {
    moviesSection.innerHTML = "";
    movies.forEach((movie, position) => {
        const htmlElement = document.createElement("div");
        htmlElement.innerHTML = `<div class="movie">
            <div 
                class="close-button" 
                onclick="fetch(\`/movies/${position}\`, { method: 'DELETE'}).then(reloadMovies)">x</div>
            <p class="title">${movie.title} (${movie.year})</p>
        </div>`;
        moviesSection.appendChild(htmlElement)
    })
}


// 2)
let reloadMovies = () => {
    fetch("/movies")
        .then(r => r.json())
        .then(showMovies)
};

// 1)
document.addEventListener("DOMContentLoaded", reloadMovies)