package com.cantu.watchlist.lib;

import java.util.List;

public interface ClassesFinder {

    List<Class> getClassesFromPackage(String packageName) throws Exception;
}
