package com.FC.SharedOfficePlatform.domain.place.dto;

import lombok.Getter;

@Getter
public class PlaceFloorStats {
    private int placeFloor;
    private long meetingRoom;
    private long studio;

    public PlaceFloorStats(
            int placeFloor,
            long meetingRoom,
            long studio
    ) {
        this.placeFloor = placeFloor;
        this.meetingRoom = meetingRoom;
        this.studio = studio;
    }

}
