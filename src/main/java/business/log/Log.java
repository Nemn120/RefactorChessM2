package business.log;

public interface Log {

    /**
     * Adds a new line of text to the log.
     *
     * @params the line of text to add
     */
    public void addToLog( String s );

    /**
     * Clears the log.
     */
    public void clearLog();

    /**
     * Gets the most recent statement added to the log.
     *
     * @return String the most recent log statement
     */
    public String getLastLog();

    public String toString();

    public void clear();
}