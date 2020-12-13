package ua.com.foxminded.java8api.validator;

public class FileNotFoundExceptionRuntime extends IllegalArgumentException {

    public FileNotFoundExceptionRuntime(String format){
        super(format);
    }
}
