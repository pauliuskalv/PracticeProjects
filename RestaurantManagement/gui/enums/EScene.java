package gui.enums;

/**
 * A enum defining all of the different
 * gui windows
 */
public enum EScene
{
    /**
     * Done
     */
    LogInPanel,
    /**
     * TODO
     * Same as RegisterPanel
     */
    RegisterAdminPanel,
    /**
     * Done
     */
    RegisterPanel,
    /**
     * TODO
     * 
     * Start session
     * Settings
     * Statistics
     * Log out
     */
    MainPanelUser,
    /**
     * TODO
     * 
     * Layout designer
     * User management
     * Product manager
     * Settings
     * Log out
     */
    MainPanelAdmin,
    /**
     * TODO
     * 
     * Toolbar with all of the available objects
     * Box with layout
     * Exit button at the bottom
     */
    LayoutDesigner,
    /**
     * TODO
     * 
     * List with all of the users
     * When a user is selected, display:
     *  - Display that user's privileges
     *  - Display button that when clicked displays that user's statistics
     *  - Option to delete user
     *  - Display user name
     *  - Display last login date
     *  - Option to migrate data from one user to another
     *  - Option to change the user's wage ( percentage from order )
     */
    UserManagement,
    /**
     * TODO
     */
    StatisticsPanelAll,
    StatisticsPanelUser,
    /**
     * TODO
     * 
     * Show a list of all products
     * Option to create a product
     * Option to delete a product
     * Option to edit a product
     * Option to filter by attribute
     */
    ProductManagement,
    /**
     * TODO
     * 
     * Option to change password
     */
    SettingsUser,
    /**
     * TODO
     * 
     * Option to change password
     * Option to change the global currency
     * Option to reset all statistics
     */
    SettingsAdmin
}