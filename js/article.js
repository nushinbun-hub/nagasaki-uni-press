// ==============================
// 注目記事スライダー
// Java生成されたHTMLを制御
// ==============================


const featuredSlider =
    document.getElementById("featured-slider");



if(featuredSlider){


    const slides =
        featuredSlider.querySelectorAll("a");



    let current = 0;



    function showSlide(){


        slides.forEach(slide => {

            slide.style.display = "none";

        });



        slides[current].style.display = "block";



        current++;



        if(current >= slides.length){

            current = 0;

        }


    }



    if(slides.length > 0){


        showSlide();



        setInterval(

            showSlide,

            4000

        );


    }


}