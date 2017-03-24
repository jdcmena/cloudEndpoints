$.get("http://localhost:8080_ah/api/elNombreNoImporta/v1/equipocollection", function(data, status){
        if(status === 'success'){
            var dataAgain = JSON.parse(data);
            for(var i = 0; i < dataAgain.length; i++)
            {
                $("#dimayor").append('<li>'+ dataAgain[i].nombreEquipo + '</li>')    
            }
        }
        else {
            console.log('Error');
        }
        
    });