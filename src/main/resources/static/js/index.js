let main = {
    init : function () {
        let _this = this;
        $('#btnOutput').on('click', function () {
            _this.btnOutput();
        });
    },

    btnOutput: function(e) {
        let url = $("#searchUrl").val();
        let type = $("#type").val();
        let outputUnit = $("#outputUnit").val();

        let param = {
            "url": url,
            "type": type,
            "outputUnit": outputUnit
        }

        $.ajax({
            type: 'GET',
            url: '/api/url/parse',
            data: param,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            success: [function (result) {
                assignResult(result);
            }
            ],
            error: [function (err) {
                console.log(err);
            }]
        });
    },
}

function assignResult(data) {
    let outputArr = [];
    outputArr.push(`<div>몫     : <span>${data["share"]}</span></div>`)
    outputArr.push(`<div>나머지  : <span>${data["remainder"]}</span></div>`)
    outputArr.push(`<div>결과 값 : <span>${data["result"]}</span></div>`)
    $("#output").html(outputArr);
}

main.init();
