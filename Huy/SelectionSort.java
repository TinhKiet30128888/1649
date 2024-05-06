public class SelectionSort {
    public static void sortBooksByAuthor(AbstractArrayList<Book> books) {
            int n = books.size();
            
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    int authorComparison = books.get(j).getAuthor().compareToIgnoreCase(books.get(minIndex).getAuthor());
                    if (authorComparison < 0 || (authorComparison == 0 && books.get(j).getTitle().compareToIgnoreCase(books.get(minIndex).getTitle()) < 0)) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    Book temp = books.get(minIndex);
                    books.set(minIndex, books.get(i));
                    books.set(i, temp);
                }
            }
        }
        
    }


