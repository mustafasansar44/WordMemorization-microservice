package com.msansar.wordgroupservice.dataFactory;

import com.msansar.wordgroupservice.dto.WordGroupResponseDto;
import com.msansar.wordgroupservice.dto.WordGroupSaveRequestDto;
import com.msansar.wordgroupservice.model.WordGroup;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordGroupTestDataFactory{

    private final static String id = "id";
    private final static String foreignWord = "foreignWord";
    private final static String localWord = "localWord";
    private static Date currentDate = new Date();

    public static WordGroup generateWordGroup(){
        return new WordGroup(id, currentDate, currentDate, foreignWord, localWord, true, 1);
    }
    public static WordGroupResponseDto generateWordGroupResponseDto(){
        return new WordGroupResponseDto(id, currentDate, currentDate, foreignWord, localWord, true, 1);
    }
    public static WordGroupSaveRequestDto generateWordGroupSaveRequestDto(){
        return new WordGroupSaveRequestDto(foreignWord, localWord, 1, "123");
    }
    public static List<WordGroup> generateWordGroupList(int initWordGroupsLength){
        return IntStream.range(0, initWordGroupsLength).mapToObj(i ->
                        new WordGroup(id+i, currentDate, currentDate, foreignWord+i, localWord+i, true, 1)
                ).collect(Collectors.toList());
    }
    public static List<WordGroupResponseDto> generateWordGroupResponseDtoList(int initWordGroupDtosLength){
        return IntStream.range(0, initWordGroupDtosLength).mapToObj(i ->
                new WordGroupResponseDto(id+i, currentDate, currentDate, foreignWord+i, localWord+i, true, 1)
        ).collect(Collectors.toList());
    }
}
