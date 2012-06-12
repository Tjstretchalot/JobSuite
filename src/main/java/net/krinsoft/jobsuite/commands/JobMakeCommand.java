package net.krinsoft.jobsuite.commands;

import net.krinsoft.jobsuite.Job;
import net.krinsoft.jobsuite.JobCore;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionDefault;

import java.util.List;

/**
 * @author krinsdeath
 */
public class JobMakeCommand extends JobCommand {

    public JobMakeCommand(JobCore instance) {
        super(instance);
        setName("JobSuite: Make");
        setCommandUsage("/job make [name]");
        setArgRange(1, 1);
        addKey("jobsuite make");
        addKey("job make");
        addKey("js make");
        setPermission("jobsuite.makejob", "Creates a job session.", PermissionDefault.TRUE);
    }

    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        Job job = new Job(sender.getName(), args.get(0));
        if (manager.addQueuedJob(sender.getName(), job)) {
            message(sender, "Job created successfully.");
            message(sender, "Now, enter a description: " + ChatColor.AQUA + "/job desc [description]");
        } else {
            error(sender, "Failed to create job.");
        }
    }
}
