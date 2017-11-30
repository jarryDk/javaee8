
interface ToDo {
  uuid: string;
  subject: string;
  body: string;
  priority: number;
  style?: string;
}

class ToDoView {

  todo: ToDo;

  constructor(todo: ToDo) {
    this.todo = todo;
    if(todo.priority == 1){
      this.todo.style = 'card-warning';
    }
  }

  renderRead() {
    return `
		<div class="col-lg-4 mb-4">
			<div class="card ${this.todo.priority}" id="todo_${this.todo.uuid}">
				<div class="card-header">${this.todo.subject}</div>
				<div class="card-block"><p>${this.todo.body}</p></div>
			</div>
		</div>
		`;
  }

}

class ToDosView {

  todoList: ToDo[];

  constructor() {
    fetch('https://todo.jarry.dk/resources/todos')
      .then(function(response) {
        console.log(response.json);
      })
      .catch(function(err) {
      // Error :(
    });
    this.todoList = [{
      subject: "hej",
      body: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque ut ante in sapien blandit luctus sed ut lacus. Phasellus urna est, faucibus nec ultrices placerat, feugiat et ligula. Donec vestibulum magna a dui pharetra molestie. Fusce et dui urna.",
      uuid: "84d1cc0b-573c-4309-9b5d-89d2fb5907b9",
      priority: 1
    },{
      subject: "Hej 2",
      body: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque ut ante in sapien blandit luctus sed ut lacus. Phasellus urna est, faucibus nec ultrices placerat, feugiat et ligula. Donec vestibulum magna a dui pharetra molestie. Fusce et dui urna.",
      uuid: "84d1cc0b-573c-4309-9b5d-89d2fb5907dd",
      priority: 1
    }];
  }

  render() {

    let todos = document.querySelector("#todos");

    this.todoList.forEach(todo => {
      let todoView = new ToDoView(todo);
      var element = document.createElement('div');
      element.innerHTML = todoView.renderRead();
      todos.appendChild(element);
    
    });
    
  }

}

function component() {
  var element = document.createElement('div');
  element.setAttribute("id", "todos");
  return element;
}

document.body.appendChild(component());

new ToDosView().render();