/* @java.file.header */

/*  _________        _____ __________________        _____
 *  __  ____/___________(_)______  /__  ____/______ ____(_)_______
 *  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
 *  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
 *  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
 */

package org.gridgain.grid.ggfs.mapreduce;

import org.gridgain.grid.ggfs.*;

import java.util.*;

/**
 * GGFS task arguments. When you initiate new GGFS task execution using one of {@code GridGgfs.execute(...)} methods,
 * all passed parameters are encapsulated in a single {@code GridGgfsTaskArgs} object. Later on this object is
 * passed to {@link GridGgfsTask#createJob(org.gridgain.grid.ggfs.IgniteFsPath, GridGgfsFileRange, GridGgfsTaskArgs)} method.
 * <p>
 * Task arguments encapsulates the following data:
 * <ul>
 *     <li>GGFS name</li>
 *     <li>File paths passed to {@code GridGgfs.execute()} method</li>
 *     <li>{@link GridGgfsRecordResolver} for that task</li>
 *     <li>Flag indicating whether to skip non-existent file paths or throw an exception</li>
 *     <li>User-defined task argument</li>
 *     <li>Maximum file range length for that task (see {@link org.gridgain.grid.ggfs.IgniteFsConfiguration#getMaximumTaskRangeLength()})</li>
 * </ul>
 */
public interface GridGgfsTaskArgs<T> {
    /**
     * Gets GGFS name.
     *
     * @return GGFS name.
     */
    public String ggfsName();

    /**
     * Gets file paths to process.
     *
     * @return File paths to process.
     */
    public Collection<IgniteFsPath> paths();

    /**
     * Gets record resolver for the task.
     *
     * @return Record resolver.
     */
    public GridGgfsRecordResolver recordResolver();

    /**
     * Flag indicating whether to fail or simply skip non-existent files.
     *
     * @return {@code True} if non-existent files should be skipped.
     */
    public boolean skipNonExistentFiles();

    /**
     * User argument provided for task execution.
     *
     * @return User argument.
     */
    public T userArgument();

    /**
     * Optional maximum allowed range length, {@code 0} by default. If not specified, full range including
     * all consecutive blocks will be used without any limitations.
     *
     * @return Maximum range length.
     */
    public long maxRangeLength();
}
