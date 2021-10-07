package edu.epam.webproject.controller.command;

import edu.epam.webproject.controller.command.impl.ChangeUserPasswordCommand;
import edu.epam.webproject.controller.command.impl.LogOutCommand;
import edu.epam.webproject.controller.command.impl.SignInCommand;
import edu.epam.webproject.controller.command.impl.SignUpCommand;
import edu.epam.webproject.controller.command.impl.UploadUserIconCommand;
import edu.epam.webproject.controller.command.impl.admin.func.ChangeUserStatusCommand;
import edu.epam.webproject.controller.command.impl.admin.go.GoToAdminAccountPageCommand;
import edu.epam.webproject.controller.command.impl.admin.go.GoToAllIrrelevantVacanciesPageCommand;
import edu.epam.webproject.controller.command.impl.admin.go.GoToAllRelevantVacanciesPageCommand;
import edu.epam.webproject.controller.command.impl.admin.go.GoToAllUsersPageCommand;
import edu.epam.webproject.controller.command.impl.go.GoToSignInPageCommand;
import edu.epam.webproject.controller.command.impl.go.GoToSignUpPageCommand;
import edu.epam.webproject.controller.command.impl.user.func.ActivateAccountCommand;
import edu.epam.webproject.controller.command.impl.user.func.AddNewVacancyCommand;
import edu.epam.webproject.controller.command.impl.user.go.GoToOfferVacancyPageCommand;
import edu.epam.webproject.controller.command.impl.user.go.GoToUserAccountPageCommand;

import java.util.EnumMap;

public class CommandProvider {
    private static final CommandProvider instance = new CommandProvider();
    private final EnumMap<CommandType, Command> commands = new EnumMap<>(CommandType.class);

    private CommandProvider() {
        commands.put(CommandType.GO_TO_SIGN_IN_PAGE_COMMAND, new GoToSignInPageCommand());
        commands.put(CommandType.GO_TO_SIGN_UP_PAGE_COMMAND, new GoToSignUpPageCommand());
        commands.put(CommandType.SIGN_IN_COMMAND, new SignInCommand());
        commands.put(CommandType.SIGN_UP_COMMAND, new SignUpCommand());
        commands.put(CommandType.LOG_OUT_COMMAND, new LogOutCommand());
        commands.put(CommandType.GO_TO_USER_ACCOUNT_PAGE_COMMAND, new GoToUserAccountPageCommand());
        commands.put(CommandType.GO_TO_ADMIN_ACCOUNT_PAGE_COMMAND, new GoToAdminAccountPageCommand());

        commands.put(CommandType.GO_TO_ALL_USERS_PAGE_COMMAND, new GoToAllUsersPageCommand());
        commands.put(CommandType.GO_TO_ALL_RELEVANT_VACANCIES_PAGE_COMMAND, new GoToAllRelevantVacanciesPageCommand());
        commands.put(CommandType.GO_TO_ALL_IRRELEVANT_VACANCIES_PAGE_COMMAND, new GoToAllIrrelevantVacanciesPageCommand());
        commands.put(CommandType.ACTIVATE_ACCOUNT_COMMAND, new ActivateAccountCommand());
        commands.put(CommandType.CHANGE_USER_STATUS_COMMAND, new ChangeUserStatusCommand());
        commands.put(CommandType.UPLOAD_USER_ICON_COMMAND, new UploadUserIconCommand());
        commands.put(CommandType.GO_TO_CHANGE_USER_PASSWORD_PAGE_COMMAND, new GoToAdminAccountPageCommand());
        commands.put(CommandType.CHANGE_USER_PASSWORD_PAGE_COMMAND, new ChangeUserPasswordCommand());
        commands.put(CommandType.ADD_NEW_VACANCY_COMMAND, new AddNewVacancyCommand());

        commands.put(CommandType.GO_TO_OFFER_VACANCY_PAGE_COMMAND, new GoToOfferVacancyPageCommand());
    }

    public static CommandProvider getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        if (commandName == null) {
            return commands.get(CommandType.DEFAULT);
        }
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException e) {
            commandType = CommandType.DEFAULT;
        }
        return commands.get(commandType);
    }
}
