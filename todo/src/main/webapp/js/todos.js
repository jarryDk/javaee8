class ToDos {
	
	constructor(){
		
	}
	
	render(){
		
		let todos = document.querySelector("#todos");
		
		let todo = new ToDo(
				{
				 "subject":"hej",
				 "body":"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque ut ante in sapien blandit luctus sed ut lacus. Phasellus urna est, faucibus nec ultrices placerat, feugiat et ligula. Donec vestibulum magna a dui pharetra molestie. Fusce et dui urna.",
				 "uuid":"84d1cc0b-573c-4309-9b5d-89d2fb5907b9"
				}
				);
		todos.innerHTML  = todo.renderRead();
	}
	
}

class ToDo{
	
	constructor(todo){
		this.todo = todo;
	}
	
	renderRead(){		
		return `
		<div class="col-lg-4 mb-4">
			<div class="card" id="todo_${this.todo.uuid}">
				<div class="card-header">${this.todo.subject}</div>
				<div class="card-block"><p>${this.todo.body}</p></div>
			</div>
		</div>
		`;
	}
	
}

var todos = new ToDos();
todos.render();