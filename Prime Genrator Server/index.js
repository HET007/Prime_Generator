function sendJSON(){ 
            let result = document.querySelector('.result');  
            let pMin = document.querySelector('#pMin');
             let pMax = document.querySelector('#pMax');
              let algoId = document.querySelector('#algoId');
              let name = document.querySelector('#name');
              let rName = document.querySelector('#rName');
              let rsResult = document.querySelector('#outResult');
               let tExicution = document.querySelector('#time');
              


              //validation 

               var vName = document.getElementById("name").value;
               var vMin = parseInt(document.getElementById("pMin").value);
               var vMax = parseInt(document.getElementById("pMax").value);
               if (vName == "" || vMin == null || vMax == null ) {
                alert("PLEASE FILL THE FIELD");
                return false;
               }
               if (vMin >= vMax) {
                    alert("PLEASE FILL THE VALID FIELD");
                    return false;
                }
              

               

             
            // Creating a XHR object 
            let xhr = new XMLHttpRequest(); 
            let url = 'http://localhost:8080/prime'; 
            // open a connection 
            xhr.open("POST", url, true); 
  
            // Set the request header and  of content you are sending 
            xhr.setRequestHeader("Content-Type", "application/json"); 
            // Create a state change callback 
            xhr.onreadystatechange = function () { 
                if (xhr.readyState === 4 && xhr.status === 200) { 
                    // Print received data from server 
                    var formate = JSON.parse(this.responseText);
                    rName.innerHTML = "Name : " + formate.name;
                    rsResult.innerHTML = "Prime numbers : " + formate.result;
                    tExicution.innerHTML = "Time Consumed : " + formate.tElapse + " Nano Seconds";
                
                } 
            }; 
  
            // Converting JSON data to string 
            var data = JSON.stringify({ "name": name.value, "pMin": pMin.value, "pMax": pMax.value, "algoId": algoId.value }); 
  
            // Sending data with the request 
            xhr.send(data); 
        } 
