/**
 * Created by java on 25.04.2016.
 */
$(document).ready(function () {
    if (found = document.location.href.match(/sort=([^&$]+)/i)) {
        $('#sorted').val(found[1]);
    }

    $('#sorted').on('change', function () {
        document.location.href = replaceUrlParam(document.location.href, 'sort', $(this).val());
    })

    function replaceUrlParam(url,paramName,paramValue) {
        var pattern= new RegExp('\\b('+paramName+'=).*?(&|$)')
        if(url.search(pattern)>=0){
            return url.replace(pattern,'$1'+ paramValue + '$2');
        }
        return url+(url.indexOf('?')>0 ? '&' : '?') + paramName + '=' + paramValue

    }

})