package game.map;

public enum Direction {
    NORTH(new Position(0, 1)) {
        public Direction getOpposite() {
            return SOUTH;
        }
    },

    SOUTH(new Position(0, -1)) {
        public Direction getOpposite() {
            return NORTH;
        }
    },

    EAST(new Position(1, 0)) {
        public Direction getOpposite() {
            return WEST;
        }
    },

    WEST(new Position(-1, 0)) {
        public Direction getOpposite() {
            return EAST;
        }
    },

    NORTHEAST(new Position(1, 1)) {
        public Direction getOpposite() {
            return SOUTHWEST;
        }
    },

    SOUTHEAST(new Position(1, -1)) {
        public Direction getOpposite() {
            return NORTHWEST;
        }
    },

    SOUTHWEST(new Position(-1, -1)) {
        public Direction getOpposite() {
            return NORTHEAST;
        }
    },

    NORTHWEST(new Position(1, 1)) {
        public Direction getOpposite() {
            return SOUTHEAST;
        }
    };

    public final Position relativePosition;

    Direction(Position relativePosition) {
        this.relativePosition = relativePosition;
    }

    public abstract Direction getOpposite();
}
