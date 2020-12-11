document
  .querySelector("form.viewRecord")
  .addEventListener("submit", function (stop) {
    stop.preventDefault();
    let formElements = document.querySelector("form.viewRecord").elements;
    console.log(formElements)

    let name=formElements["nameInput"].value;



    let data = {

      "title":name

    }
    console.log("Data to post",data)
  

    create(data)
    window.location.replace("startPage.html");
    // postData(noteTitle,noteBody)
  });

  function create(data){
    fetch("http://localhost:9092/list/create", {
        method: 'post',
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        },
        body:JSON.stringify(data)
      })
      .then(function (data) {
        console.log('Request succeeded with JSON response', data);
      })
      .catch(function (error) {
        console.log('Request failed', error);
      });
    }