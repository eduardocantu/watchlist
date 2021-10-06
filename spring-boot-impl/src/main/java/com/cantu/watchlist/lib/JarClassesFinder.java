package com.cantu.watchlist.lib;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * A implementation of ClassFinder to find classes inside jar files.
 */
public class JarClassesFinder implements ClassesFinder {

    @Override
    public List<Class> getClassesFromPackage(String packageName) throws Exception {
        List<Class> classes = new ArrayList();
        for (JarInputStream jar : getAllJarsFromPackage(packageName)) {
            classes.addAll(getClassesOfPackageNameFromJar(packageName, jar));
        }
        return classes;
    }

    private List<JarInputStream> getAllJarsFromPackage(String packageName) throws Exception {
        final String sanitizedPackageName = packageName.replace('.', '/');

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration resources = classLoader.getResources(sanitizedPackageName);

        List<JarInputStream> dirs = new ArrayList();
        while (resources.hasMoreElements()) {
            URL resource = (URL) resources.nextElement();
            String jarName = getJarNameFrom(resource);
            //dirs.add(new JarInputStream(new FileInputStream(jarName)));
        }
        return dirs;
    }

    private String getJarNameFrom(URL resource) throws Exception {
        String jarName = resource.getPath();
        jarName = jarName
                .replaceAll("file:/", "")
                .replaceAll("%20", " ");

        if (jarName.contains("!")) {
            jarName = jarName.substring(0, jarName.indexOf("!"));
        }
        return jarName;
    }

    private List<Class> getClassesOfPackageNameFromJar(String packageName, final JarInputStream jarFile) throws Exception {
        String packageNameAsFolder = packageName.replace(".", "/");

        JarEntry jarEntry = jarFile.getNextJarEntry();
        List<Class> classes = new ArrayList<>();
        while (jarEntry != null) {

            boolean isClass = jarEntry.getName().endsWith(".class");
            boolean isClassOfPackage = jarEntry.getName().startsWith(packageNameAsFolder);

            if (isClass && isClassOfPackage) {
                String className = getClassNameFrom(jarEntry);
                try {
                    classes.add(Class.forName(className));
                } catch (NoClassDefFoundError e) {
                    e.printStackTrace();
                }
            }
            jarEntry = jarFile.getNextJarEntry();
        }

        return classes;
    }

    private String getClassNameFrom(JarEntry jarEntry) throws Exception {
        String className = jarEntry.getName().replaceAll("/", "\\.");
        return className.substring(0, className.lastIndexOf('.'));
    }
}
