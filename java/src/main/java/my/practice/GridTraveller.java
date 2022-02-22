package my.practice;

import java.util.ArrayList;

public class GridTraveller {

    private GridTraveller(){
        //Do nothing constructor
    }

    /***
     * Returns number of possible routes for a given grid size
     * @param rows number of rows in the grid
     * @param columns number of columns in the grid
     * @return number of possible routes
     */
    public static long getRoutes(int rows, int columns) {
        return getRoutes(rows, columns, new ArrayList<>());
    }

    private static long getRoutes(int rows, int columns, ArrayList<RouteInfo> memo) {

        for (RouteInfo routeInfo : memo) {
            if(routeInfo.row() == rows && routeInfo.column() == columns)
                return routeInfo.route();
        }

        if(rows == 1 && columns == 1)
            return rows;
        if( rows == 0 || columns == 0)
            return 0;

        final long newRoute = getRoutes(rows - 1, columns, memo) + getRoutes(rows, columns - 1, memo);

        memo.add(new RouteInfo(rows, columns, newRoute));

        return newRoute;
    }

    private record RouteInfo(int row, int column, long route){ }
}