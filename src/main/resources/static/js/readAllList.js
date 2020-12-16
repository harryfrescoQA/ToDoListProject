
// Read all lists
fetch('http://localhost:9092/list/read')
  .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Error. Status Code: ' + response.status);
        return;
      }

      response.json().then(function(data) {
        let div = document.querySelector("#readList");
        // Send data to function with the div it needs to be in
        showData(div,data);

      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });


function showData(div,data){
    for(let record of data){
      // For each list, create a div to hold it, and their buttons
      let newDiv = document.createElement("div");
      newDiv.setAttribute("class", "col-12");
      newDiv.setAttribute("id", "listDiv");

      for(let values in record){
        console.log(record[values])
       
        if(Array.isArray(record[values])==false && record[values]!=null){

            let text = document.createTextNode(record[values]+"     ");
            newDiv.appendChild(text);
            div.appendChild(newDiv);
            let br = document.createElement("br");
            div.appendChild(br)
                  
        }
        else{

        }
           
      }
      // Create buttons for each list
      // View button
      let viewButton = document.createElement("a");
      let viewButtonValue = document.createTextNode("View")
      viewButton.className ="btn btn-primary";
      viewButton.setAttribute("id", "listButton");
      viewButton.href="readList.html?id="+record.id
      viewButton.appendChild(viewButtonValue);
      newDiv.appendChild(viewButton)

      // Edit button
      let editButton = document.createElement("a");
      let editButtonValue = document.createTextNode("Edit Title")
      editButton.className ="btn btn-secondary";
      editButton.setAttribute("id", "listButton");
      editButton.href="editList.html?id="+record.id
      editButton.appendChild(editButtonValue);
      newDiv.appendChild(editButton);

      // Delete button
      let deleteButton = document.createElement("button");
      let deleteButtonValue = document.createTextNode("Delete this List")
      deleteButton.className ="btn btn-danger";
      deleteButton.setAttribute("id", "listButton");
      // Delete list
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

// Delete list
function deleteByid(id){
  fetch("http://localhost:9092/list/delete/"+id, {
      method: 'delete',
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      },
    })}