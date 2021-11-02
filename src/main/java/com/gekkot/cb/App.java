package com.gekkot.cb;

import com.gekkot.cb.params.ApiParams;
import com.gekkot.cb.rest.ApiClient;
import com.gekkot.cb.rest.common.callback.IDataErrorCallback;
import com.gekkot.cb.rest.common.callback.INetworkExceptionCallback;
import com.gekkot.cb.rest.common.callback.IResultCallback;
import com.gekkot.cb.rest.projects.ProjectCaller;
import com.gekkot.cb.rest.projects.ProjectShortInfoPojo;
import com.gekkot.cb.rest.time.TimeCaller;
import com.gekkot.cb.rest.time.TimePojo;
import com.gekkot.cb.rest.user.UserCaller;
import com.gekkot.cb.rest.user.UserPojo;
import com.gekkot.cb.rest.version.VersionCaller;
import org.apache.commons.cli.*;

import java.util.List;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Options options = new Options();

        Option cbAddressOption = new Option("u", "url", true, "url of codebeamer");
        cbAddressOption.setRequired(true);
        options.addOption(cbAddressOption);

        Option usernameOption = new Option("U", "username", true, "username");
        usernameOption.setRequired(true);
        options.addOption(usernameOption);

        Option passwordOption = new Option("P", "password", true, "password");
        passwordOption.setRequired(true);
        options.addOption(passwordOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException ex) {
            System.out.println(ex);
            formatter.printHelp("codebeamer-api-client", options);

            System.exit(1);
            return;
        }
        //final String inputPath = cmd.getOptionValue("path");
        final String url = cmd.getOptionValue("url");
        final String username = cmd.getOptionValue("username");
        final String password = cmd.getOptionValue("password");

        ApiParams apiParams = new ApiParams(url);
        apiParams.setLogin(username);
        apiParams.setPassword(password);

        ApiClient.setParams(apiParams);

        IDataErrorCallback dataErrorCallback = dataError -> System.out.printf("user data error: %s\n", dataError.toString());
        INetworkExceptionCallback networkExceptionCallback = Throwable::printStackTrace;

        IResultCallback<String> versionResultCallback = value -> System.out.printf("version: %s\n", value);


        VersionCaller.getInstance().doCall(versionResultCallback, dataErrorCallback, networkExceptionCallback);


        IResultCallback<UserPojo> userPojoResultCallback = value -> System.out.printf("get user info: %s\n", value.getFirstName());



      new UserCaller(username)
                .doCall(userPojoResultCallback,dataErrorCallback, networkExceptionCallback);



        IResultCallback<TimePojo> timePojoResultCallback = value -> System.out.println(value.getDate());


        new TimeCaller().doCall(timePojoResultCallback, dataErrorCallback, networkExceptionCallback);

        IResultCallback<List<ProjectShortInfoPojo>> resultCallback = value -> System.out.println(value.size());

        new ProjectCaller().doCall(resultCallback,dataErrorCallback,networkExceptionCallback);


    }
}
