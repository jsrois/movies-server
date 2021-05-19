const moviesSection = document.querySelector("#movies-section");

// 3)
function showMovies(movies) {
    moviesSection.innerHTML="";
    movies.forEach((movie, i) => {
        const htmlElement = document.createElement("div");
        htmlElement.innerHTML = `<div class="movie">
            <p class="title">${movie.title} (${movie.year})</p>
        </div>`;
        htmlElement.addEventListener("click", function(){
            fetch(`/movies/${i}`, { method: 'DELETE'}).then(loadMovies)
        })
        moviesSection.appendChild(htmlElement)
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