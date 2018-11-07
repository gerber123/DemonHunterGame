(function () {
    var preload = document.getElementById("preload");
    var loading =0;
    var id = setInterval(frame,64);

    function frame()
    {
        if(loading==20)
        {
            clearInterval(id);
            window.open("homepage","_self");
        }
        else
        {
            loading=loading+1;
            if(loading==15)
            {
                preload.style.animation="fadeout 2s easy";
            }
        }
    }

})();