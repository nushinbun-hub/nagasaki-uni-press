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
// 全ページ共通検索
// ==============================

const searchInput =
    document.getElementById("searchInput");


if(searchInput){

    searchInput.addEventListener(
        "keydown",
        function(event){

            // Enterキーで検索
            if(event.key === "Enter"){

                const keyword =
                    searchInput.value.trim();


                // 空欄なら何もしない
                if(keyword === ""){
                    return;
                }


                // 検索結果ページへ移動
                window.location.href =
                    "search.html?q="
                    + encodeURIComponent(keyword);

            }

        }
    );

}

// ==============================
// 検索結果ページ
// ==============================

const searchResults =
    document.getElementById("search-results");


if(searchResults){

    const params =
        new URLSearchParams(
            window.location.search
        );


    const keyword =
        params.get("q");


    const searchTitle =
        document.getElementById("search-title");


    if(!keyword){

        searchTitle.textContent =
            "検索結果";

        searchResults.innerHTML =
            "<p>検索キーワードを入力してください。</p>";

    }
    else{

        searchTitle.textContent =
            "「" + keyword + "」の検索結果";


        fetch("articles.json")

            .then(response => response.json())

            .then(articles => {

                const lowerKeyword =
                    keyword.toLowerCase();


                const result =
                    articles.filter(article => {

                        const text =
                            article.title +
                            article.category +
                            article.summary +
                            article.content;


                        return text
                            .toLowerCase()
                            .includes(lowerKeyword);

                    });


                if(result.length === 0){

                    searchResults.innerHTML =
                        "<p>該当する記事がありません。</p>";

                    return;

                }


                result.forEach(article => {

                    searchResults.innerHTML += `

<article class="news-item">

    <img
        src="${article.image}"
        alt="${article.title}">

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

            })

            .catch(error => {

                console.error(
                    "記事データ読み込みエラー:",
                    error
                );

                searchResults.innerHTML =
                    "<p>記事データを読み込めませんでした。</p>";

            });

    }

}