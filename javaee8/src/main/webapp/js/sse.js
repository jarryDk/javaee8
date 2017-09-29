class Events {

	constructor(){
		this.events = new EventSource("https://mni.convergens.dk:8181/javaee8/resources/beats");
		this.events.onerror = (e) =>  console.log("Error !" + e);
		this.events.onopen = (e) => console.log(e);
		//this.events.onmessage = (e) => console.log(e);
		this.events.onmessage = ({data}) => console.log(data);
	}
	
}

new Events();