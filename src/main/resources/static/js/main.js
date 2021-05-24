const moviesSection = document.querySelector("#movies-section");

// 3)
function showMovies(movies) {
    moviesSection.innerHTML = "";
    for (let [id, movie] of Object.entries(movies)){
        const htmlElement = document.createElement("div");
        htmlElement.innerHTML = `<div class="movie">
            <div 
                class="close-button" 
                onclick="fetch(\`/movies/${id}\`, { method: 'DELETE'}).then(reloadMovies)">x</div>
            <p class="title">${movie.title} (${movie.year})</p>
        </div>`;
        moviesSection.appendChild(htmlElement)
    }
}


// 2)
let reloadMovies = () => {
    fetch("/movies")
        .then(r => r.json())
        .then(showMovies)
};

// 1)
document.addEventListener("DOMContentLoaded", reloadMovies)