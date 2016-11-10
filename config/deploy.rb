
set :dirs_to_create, ["releases", "shared/conf"]
set :tomcat_dirs_to_symlink, ["logs","work","temp", "conf"]
set :tomcat_dirs_to_create, ["webapps"]
set :config_files, ["conf/configs.prop"]
#set(:war_filename) { "#{application}.war" }
set :war_filename, "SoapApi-1.0.war"
set :source_war_path, "../#{application}/target/#{war_filename}"
set :start_commands, ["/etc/init.d/tomcat_soap_api start"]
set :stop_commands, ["/etc/init.d/tomcat_soap_api stop"]
set :restart_commands, stop_commands + start_commands

after "deploy:update_code", "tomcat:unpack_war"
after "tomcat:unpack_war", "tomcat:finalize_unpacked_war"

namespace :service_status do
  desc "Check tomcat service started successfully"
  task "check_status" do
    run "sleep 10; ps -ef | grep tomcat | grep -v grep | awk '{ print $2 }' ; rc=$?; if [ $rc != 0 ]; then echo \"Error #{tomcat} service not started \" ; exit $rc; fi"
  end
end

after "deploy:start", "service_status:check_status"