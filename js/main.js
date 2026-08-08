// ==============================
// 注目記事スライダー
// ==============================


const featuredSlider =
    document.getElementById("featured-slider");



if(featuredSlider){


    const slides =
        featuredSlider.querySelectorAll("a");



    let current = 0;



    if(slides.length > 0){



        slides.forEach((slide, index)=>{

            if(index !== 0){

                slide.style.display = "none";

            }

        });



        setInterval(()=>{



            slides[current].style.display = "none";



            current++;



            if(current >= slides.length){

                current = 0;

            }



            slides[current].style.display = "block";



        },4000);



    }


}





// ==============================
// 全記事検索
// articles.json使用
// ==============================


const searchInput =
    document.getElementById("searchInput");



const newsGrid =
    document.getElementById("news-grid");



if(searchInput && newsGrid){



    let allArticles = [];



    fetch("articles.json")


    .then(response => response.json())


    .then(data => {


        allArticles = data;


    })


    .catch(error => {


        console.error(
            "記事データ読み込みエラー:",
            error
        );


    });





    searchInput.addEventListener(
        "keyup",
        function(){



            const keyword =
                searchInput.value
                .toLowerCase();



            if(keyword === ""){


                location.reload();


                return;


            }





            const result =
                allArticles.filter(article => {



                    const text =

                        article.title +

                        article.category +

                        article.summary +

                        article.content;



                    return text
                    .toLowerCase()
                    .includes(keyword);



                });





            newsGrid.innerHTML = "";





            result.forEach(article => {



                newsGrid.innerHTML += `


<article class="news-item">


<img src="${article.image}" alt="${article.title}">


<div class="news-content">


<p class="category ${article.category}">

${article.category}

</p>


<h3>${article.title}</h3>


<p>${article.summary}</p>


<small>${article.date}</small>


<br><br>


<a href="${article.link}">

続きを読む →

</a>


</div>


</article>


`;



            });



        }

    );



}