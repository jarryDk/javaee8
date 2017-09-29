package dk.jarry.javaee8.boundary;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

@Path("beat2")
public class BeatResources2 {
	
	@Context 
	private Sse sse;
	
	private SseBroadcaster broadcaster;

	@PostConstruct
	public void init() {
		this.broadcaster = sse.newBroadcaster();
	}

	@GET
	@Produces(MediaType.SERVER_SENT_EVENTS)
	public void register(@Context SseEventSink eventSink) {
			broadcaster.register(eventSink);
	}
	
	@Schedule(second = "*/2" , minute = "*" , hour = "*")
	public void beat() {
		this.broadcaster.broadcast(this.sse.newEvent("time: " + ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT)));
	}

}
