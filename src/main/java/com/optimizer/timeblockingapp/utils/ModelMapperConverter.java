package com.optimizer.timeblockingapp.utils;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ModelMapperConverter {

    public static <Source, Destination> Destination convertObject(Source source, Class<Destination> destination) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(source, destination);
    }

    public static <Source, Destination> List<Destination> convertList(List<Source> sources, Class<Destination> destination) {
        List<Destination> destinationList = new ArrayList<>();
        for (Source source : sources) {
            destinationList.add(convertObject(source, destination));
        }
        return destinationList;
    }

}
