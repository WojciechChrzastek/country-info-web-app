//-----NAVBAR-SHNINK-ON-SCROLL-----
$(document).ready(function () {
  var toggleAffix = function (affixElement, scrollElement, wrapper) {
    var height = affixElement.outerHeight(),
      top = wrapper.offset().top;
    if (scrollElement.scrollTop() >= top) {
      wrapper.height(height);
      affixElement.addClass("affix");
    } else {
      affixElement.removeClass("affix");
      wrapper.height("auto");
    }
  };
  $('[data-toggle="affix"]').each(function () {
    var ele = $(this),
      wrapper = $("<div></div>");
    ele.before(wrapper);
    $(window).on("scroll resize", function () {
      toggleAffix(ele, $(this), wrapper);
    });
    // init
    toggleAffix(ele, $(window), wrapper);
  });
});

//-----NAVBAR-COLLAPSE-----
$(".navbar-nav>a").on("click", function () {
  $(".navbar-collapse").collapse("hide");
});

//-----SCROLL-BUTTON-----
mybutton = document.getElementById("scrollButton");
window.onscroll = function () {
  scrollFunction();
};

function scrollFunction() {
  if (
    document.body.scrollTop > 500 ||
    document.documentElement.scrollTop > 500
  ) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}