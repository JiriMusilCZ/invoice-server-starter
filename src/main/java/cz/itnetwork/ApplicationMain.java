/*  _____ _______         _                      _
 * |_   _|__   __|       | |                    | |
 *   | |    | |_ __   ___| |___      _____  _ __| | __  ___ ____
 *   | |    | | '_ \ / _ \ __\ \ /\ / / _ \| '__| |/ / / __|_  /
 *  _| |_   | | | | |  __/ |_ \ V  V / (_) | |  |   < | (__ / /
 * |_____|  |_|_| |_|\___|\__| \_/\_/ \___/|_|  |_|\_(_)___/___|
 *                                _
 *              ___ ___ ___ _____|_|_ _ _____
 *             | . |  _| -_|     | | | |     |  LICENCE
 *             |  _|_| |___|_|_|_|_|___|_|_|_|
 *             |_|
 *
 *   PROGRAMOVÁNÍ  <>  DESIGN  <>  PRÁCE/PODNIKÁNÍ  <>  HW A SW
 *
 * Tento zdrojový kód je součástí výukových seriálů na
 * IT sociální síti WWW.ITNETWORK.CZ
 *
 * Kód spadá pod licenci prémiového obsahu a vznikl díky podpoře
 * našich členů. Je určen pouze pro osobní užití a nesmí být šířen.
 * Více informací na http://www.itnetwork.cz/licence
 *
 *   PROGRAMMING  <>  DESIGN  <>  WORK/ENTERPRISE  <>  HW AND SW
 *
 * This source code is part of educational series on
 * the IT social network WWW.ITNETWORK.CZ
 *
 * The code is covered under a premium content license and was created with the support
 * of our members. It is intended for personal use only and must not be distributed.
 * For more information, visit http://www.itnetwork.cz/licence
 */

package cz.itnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.
 *
 * <p>This class initializes and runs the Spring Boot application. It serves as the entry
 * point for the application and is responsible for launching the Spring application context.</p>
 *
 *@author Jiří Musil / IT network s.r.o.
 * version 1.0
 */
@SpringBootApplication
public class ApplicationMain {

    /**
     * The main method that starts the Spring Boot application.
     *
     * <p>It launches the application by calling {@link SpringApplication#run(Class, String[])}
     * with the main application class as an argument.</p>
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
