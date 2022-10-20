package contacts;

import java.io.File;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;


@ArquillianSuiteDeployment
public class Deployments {

	
    @Deployment  
    public static Archive<?> getEarArchive() {
    	
    	System.setProperty( "org.apache.maven.user-settings", "C:\\dev23\\utils\\maven\\conf\\settings.xml" );

        var ear = ShrinkWrap.create(EnterpriseArchive.class, "contacts-ejb.ear");
    	
        var ejb = ShrinkWrap
				.create(JavaArchive.class, "contacts-ejb.jar")              
				.addPackage("contacts.ejb.dao")                
				.addPackage("contacts.ejb.dao.jpa")                
				.addPackage("contacts.ejb.data")                
				.addPackage("contacts.ejb.data.mapper")                
				.addPackage("contacts.ejb.service.standard")                
        		.addAsResource( "META-INF/persistence.xml" )
		        .addAsResource(  new File("../scripts-sql/3-data.sql") )
				;
        ear.addAsModule(ejb);
    	
        File[] ejbDependencies = Maven.resolver()
			.loadPomFromFile("../contacts-ejb/pom.xml")
			.importRuntimeDependencies()
			.resolve()
			.withTransitivity()
			.asFile();   
		for (File archive : ejbDependencies) {  
			ear.addAsLibrary(archive);  
		}   
	     
        // Export the EAR file to examine it in case of problems:
		ear.as(ZipExporter.class).exportTo(new File("C:\\TEMP\\contacts-ejb.ear"), true);

		return ear;
    }
}
