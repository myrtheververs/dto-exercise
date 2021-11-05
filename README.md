# TIL

`Today I Learned #TIL` is the flagship application of Switchfully.

With this piece of software, we will take over the world. 

Only ... there are a few bugs :-(

## Setup
* Use template in Github (it will allow you to make a copy of this repo in your own Github. No clone, no fork. Just your own copy which you can work and comnit on)
* Run `index.html` => right click + run
* Run the Spring Boot application

## Let's go bug hunting
* The package structure is horrible
  * Make an `api` package, which contains the controller
  * Make a `service` package, which contains the ... service :-)
  * Make a `repository` package
  * What about Person? What about Til?
* The UI is very buggy (aka it simply does not work) ... but the UI CANNOT BE CHANGED
  * Have a look at `index.html`, and investigate the code pasted below thoroughly. 
  ```<div class="mb-3 row">
    <label for="textarea-1636054888260" class="formbuilder-textarea-label">and today I learned</label>
    <textarea type="textarea" class="form-control" name="til" id="textarea-1636054888260"
    required="true"></textarea>
    </div>
    ```
  * The above code is responsible for the field which will add what we have learned today. More specifically the name attribute will connect our input to our backend. What is going wrong here and how can we fix it? Look at the rest of our `index.html` file and see if there are any other issues present.
  * Take a good look at `Til.java`. We have added the differences between what our UI is expecting and what Postman is expecting. This poses quite some bugs.
  * Investigate the endpoints for this particular application. There are several present at the moment in `TilController`. Get a feel of the functionalities present and check for yourself if they work or not.
  * Make changes to `Til.java` (if necessary, create DTOs). Remember that DTOs can help us control what we pass on whenever our application communicates with the outer world through our API. Different endpoints might ask for different DTOs, specifically tailored for this functionality.
  * Not sure how a DTO and its mapper are made again in Java? There's no shame in going back to previous projects to refresh your memory. Make sure to try to grasp how they are connected and work inside your application though, don't just copy/paste.
  * Make sure to NOT change the Postman / Swagger UI (because the CEO uses this already)
* Potential problem
  * Why can't you delete #TILs? (This might already be solved, due to the dtos)

## Hints and extra's
* Use the debugger to explore / investigate
* The java code is horrible, feel free to refactor ;-)

## Future?
* In a next version
  * Dto's in Dto's (OwnerDto in TilDto)
  * Attach it to a real database
  * A better UI
