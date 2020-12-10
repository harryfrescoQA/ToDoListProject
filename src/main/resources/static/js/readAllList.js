fetch('http://localhost:9092/list/read')
  .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Looks like there was a problem. Status Code: ' +
          response.status);
        return;
      }

      // Examine the text in the response
      response.json().then(function(commentData) {
       

        let div = document.querySelector("#readList");
        let data = Object.keys(commentData[0]);
        
        createTitles(div,data);
        createTableBody(div,commentData);
        
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });

function createTitles(div,data){
    let h1 = document.createElement("h1");
    for(let keys of data){
        
        // console.log("data",data)
     
        let text = document.createTextNode(keys);
        h1.appendChild(text);
        div.appendChild(h1)
        
    }


    //let h2 = document.createElement("h1")
    let text2 = document.createTextNode("   View");
    h1.appendChild(text2);
    div.appendChild(h1);
   // let h1 = document.createElement("h1")
    let text3 = document.createTextNode("   Edit");
    h1.appendChild(text3);
    div.appendChild(h1)
    //let h4 = document.createElement("h1")
    let text4 = document.createTextNode("   Delete");
    h1.appendChild(text4);
    div.appendChild(h1);
}