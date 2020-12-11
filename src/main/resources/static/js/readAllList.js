fetch('http://localhost:9092/list/read')
  .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Looks like there was a problem. Status Code: ' +
          response.status);
        return;
      }

      // Examine the text in the response
      response.json().then(function(data) {
       

        let div = document.querySelector("#readList");
        let dataKeys = Object.keys(data[0]);
        
        //createTitles(div,data);
        showData(div,data);
        
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });
  function showData(div,data){
    for(let record of data){
      let newDiv = document.createElement("div");
      newDiv.setAttribute("class", "col-12");
      newDiv.setAttribute("id", "listDiv");
      
       // let newDiv = table.insertRow();
        
        for(let values in record){
         console.log(record[values])
          //let text = document.createTextNode(record[values]);
          //newDiv.appendChild(text);
          //div.appendChild(newDiv)
            //let cell = row.insertCell(); console.log(record[values])
             if(Array.isArray(record[values])==false && record[values]!=null){
              //  for(let items in record[values]){
              //   //  let text = document.createTextNode(record[values][items].id + " - "+
              //   //                                     record[values][items].title  + " - "+
              //   //                                     record[values][items].message + " - "+
              //   //                                     record[values][items].done
                
                
              //   //                                     );
              //   //  // newDiv.appendChild(text);
              //   //   //div.appendChild(newDiv)
              //   //   let br = document.createElement("br");
              //   //   newDiv.appendChild(text);
              //   //   div.appendChild(newDiv);
              //   //   div.appendChild(br);

              //  }
                  let text = document.createTextNode(record[values]+"     ");
                  newDiv.appendChild(text);
                  div.appendChild(newDiv);
                  let br = document.createElement("br");
                  div.appendChild(br)
                  
             }
             else{
                // let text = document.createTextNode(record[values]);
                // newDiv.appendChild(text);
             }
           
        }
    

          //let newCell = row.insertCell();
          let viewButton = document.createElement("a");
          let viewButtonValue = document.createTextNode("View")
          viewButton.className ="btn btn-primary";
          viewButton.setAttribute("id", "listButton");
          viewButton.href="readList.html?id="+record.id
          viewButton.appendChild(viewButtonValue);
          newDiv.appendChild(viewButton)

          let editButton = document.createElement("a");
          let editButtonValue = document.createTextNode("Edit Title")
          editButton.className ="btn btn-secondary";
          editButton.setAttribute("id", "listButton");
          editButton.href="editList.html?id="+record.id
          editButton.appendChild(editButtonValue);
          newDiv.appendChild(editButton);


        
        let deleteButton = document.createElement("button");
        let deleteButtonValue = document.createTextNode("Delete this List")
        deleteButton.className ="btn btn-danger";
        deleteButton.setAttribute("id", "listButton");
        deleteButton.onclick = function(){
          deleteByid(record.id);
          alert("Deleted!");
          window.location.reload;
          return false;
        };
        deleteButton.appendChild(deleteButtonValue);
        newDiv.appendChild(deleteButton)
    }
}
function deleteByid(id){
  fetch("http://localhost:9092/list/delete/"+id, {
      method: 'delete',
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      },
    })}
// function createTitles(div,data){
//     let h1 = document.createElement("h1");
//     for(let keys of data){
        
//         // console.log("data",data)
     
//         let text = document.createTextNode("  "+keys);
//         h1.appendChild(text);
//         div.appendChild(h1)
        
//     }


//     //let h2 = document.createElement("h1")
//     let text2 = document.createTextNode("   View");
//     h1.appendChild(text2);
//     div.appendChild(h1);
//    // let h1 = document.createElement("h1")
//     let text3 = document.createTextNode("   Edit");
//     h1.appendChild(text3);
//     div.appendChild(h1)
//     //let h4 = document.createElement("h1")
//     let text4 = document.createTextNode("   Delete");
//     h1.appendChild(text4);
//     div.appendChild(h1);
// }