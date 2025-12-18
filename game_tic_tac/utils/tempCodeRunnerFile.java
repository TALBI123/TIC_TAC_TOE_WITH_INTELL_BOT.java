public static ColorText getInstance() {
        if (instance == null) {
            instance = new ColorText();
        }
        return instance;
    }