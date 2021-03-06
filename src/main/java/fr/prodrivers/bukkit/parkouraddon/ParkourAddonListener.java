package fr.prodrivers.bukkit.parkouraddon;

import me.A5H73Y.parkour.event.PlayerFinishCourseEvent;
import me.A5H73Y.parkour.event.PlayerJoinCourseEvent;
import me.A5H73Y.parkour.event.PlayerLeaveCourseEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ParkourAddonListener implements Listener {
	@EventHandler
	public void onPlayerJoinCourseEvent( PlayerJoinCourseEvent event ) {
		if( !Players.joinParkour( event.getPlayer(), event.getCourseName() ) ) {
			event.setCancelled( true );
		}
	}

	@EventHandler
	public void onPlayerLeaveCourseEvent( PlayerLeaveCourseEvent event ) {
		if( !Players.leaveParkour( event.getPlayer() ) ) {
			event.setCancelled( true );
		}
	}

	@EventHandler
	public void onPlayerFinishParkour( PlayerFinishCourseEvent event ) {
		Players.insertCompletionAndRankAsync( event.getPlayer(), event.getCourseName() );
	}

	@EventHandler
	public void onPlayerCommandPreprocessEvent( PlayerCommandPreprocessEvent event ) {
		String command = event.getMessage();
		if( command.startsWith( "/pa " ) ) {
			if( command.startsWith( "/pa join " ) ) {
				event.setCancelled( true );

				Bukkit.getScheduler().runTask( ParkourAddonPlugin.plugin, () -> Players.joinParkour( event.getPlayer(), command.substring( 9 ) ) );
			} else if( command.startsWith( "/pa leave" ) ) {
				event.setCancelled( true );

				Bukkit.getScheduler().runTask( ParkourAddonPlugin.plugin, () -> Players.leaveParkour( event.getPlayer() ) );
			} else if( command.startsWith( "/pa lobby" ) ) {
				event.setCancelled( true );

				Bukkit.getScheduler().runTask( ParkourAddonPlugin.plugin, () -> Players.leaveParkour( event.getPlayer() ) );
			} else if( command.startsWith( "/pa joinall" ) ) {
				event.setCancelled( true );
			}
		}
	}

	@EventHandler
	public void onPlayerQuit( PlayerQuitEvent event ) {
		ParkourSelectionUI.reload( event.getPlayer() );
	}
}
