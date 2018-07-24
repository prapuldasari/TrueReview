/* 
    Document   : main
    Created on : Feb 23, 2017, 9:17:56 PM
    Author     : Nikhil Hegde
*/

/* Function to add text boxes dynamically */
function change(value){
    var innerElement = "";
    var labelElement = "";
    var element = document.getElementById("parentDiv");
   while (element.hasChildNodes()) {   
    element.removeChild(element.firstChild);
   }
    for(var i=1; i<=value; i++){
        innerElement = document.createElement("input");
        labelElement = document.createElement("label");
        labelElement.innerHTML = "Answer"+i+"* ";
        innerElement.type = "text";
        element.appendChild(labelElement);
        element.appendChild(innerElement); 
    }     
}



